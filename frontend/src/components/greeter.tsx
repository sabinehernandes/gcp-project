import { useState } from "react";

export default function Greeter() {
  const [name, setName] = useState("Hernandes");

  const handleSubmit = (input: React.FormEvent) => {
    input.preventDefault();
    alert(name);
    setName("");
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
    </>
  );
}
