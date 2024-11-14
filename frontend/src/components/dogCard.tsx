import { dogInstance } from "./types";

export default function DogCard(prop: dogInstance) {
  return (
    <>
      <div>
        <img src={prop.imgUrl} alt="" />
        <h2>{prop.name}</h2>
        <p>
          {prop.breed}, {prop.age}
        </p>
      </div>
    </>
  );
}
