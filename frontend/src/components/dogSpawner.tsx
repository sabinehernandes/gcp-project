import { useState } from "react";
import { dogDto } from "./types";
import { QueryClient, useQueryClient } from "@tanstack/react-query";

const tempPath = "http://localhost:8080/";
const path = "https://chilis-say-hi-876198057788.europe-north1.run.app/";

export const deleteDog = async (id: string) => {
  try {
    const response = await fetch(path + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
    });

    if (!response.ok) {
      throw new Error("FAIL TO DELETE DOG");
    }
  } catch (error) {
    throw error;
  }
};

export default function Dogspawner() {
  const [file, setFile] = useState<File | null>(null);

  const [name, setName] = useState("Hernandes");
  const [breed, setBreed] = useState("Husky");
  const [age, setAge] = useState(0);
  const [greeting, setGreeting] = useState("Results are here");
  const query = useQueryClient();

  const handleSubmit = async (input: React.FormEvent) => {
    input.preventDefault();

    const doggy: dogDto = {
      name: name,
      breed: breed,
      age: age,
    };
    console.log("doggy ", JSON.stringify(doggy));
    const response = await fetch(path + "canines", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(doggy),
    });
    const json = await response.json();
    setGreeting(json.name + " was created! Find it at  " + json.id);
    const imgData = new FormData();
    if (file) imgData.append("file", file);
    const rez = await fetch(path + "canines/img/" + json.id, {
      method: "POST",
      headers: {},
      body: imgData,
    });
    query.invalidateQueries();
  };

  return (
    <>
      <form onSubmit={(e) => handleSubmit(e)}>
        <label>
          Name:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          ></input>
        </label>

        <label>
          Breed:
          <input
            type="text"
            value={breed}
            onChange={(e) => setBreed(e.target.value)}
          ></input>
        </label>

        <label>
          Age:
          <input
            type="number"
            value={age}
            onChange={(e) => setAge(parseInt(e.target.value))}
          ></input>
        </label>
        <label className="flex items-center space-x-10 min-w-0 ">
          File:
          <input
            className="input bg-gray-50 h-8 bg-transparent  "
            type="file"
            accept="img/*"
            onChange={(e) => {
              if (e.target.files && e.target.files[0]) {
                setFile(e.target.files[0]);
              }
            }}
          />
        </label>
        <button type="submit">Some text just too</button>
      </form>
      <div>{greeting}</div>
    </>
  );
}
