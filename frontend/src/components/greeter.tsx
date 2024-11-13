import { useState } from "react";

export default function Greeter() {
  const [name, setName] = useState("Hernandes");

  return (
    <>
      <form>
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
