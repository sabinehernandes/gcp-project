import { useState } from "react";

const path = "https://chilis-say-hi-876198057788.europe-north1.run.app/";

export default function Greeter() {
  const [name, setName] = useState("Hernandes");
  const [greeting, setGreeting] = useState("Will be here");

  const handleSubmit = async (input: React.FormEvent) => {
    input.preventDefault();
    const response = await fetch(path + "greet/" + name, { method: "GET" });
    // const json = await response.json();
    setGreeting(await response.text());
  };

  return (
    <>
      <form onSubmit={(e) => handleSubmit(e)}>
        <label>
          Greeting:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          ></input>
        </label>
        <button type="submit">Some text just too</button>
      </form>
      <div>{greeting}</div>
    </>
  );
}
