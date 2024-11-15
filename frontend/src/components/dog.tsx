import { useQuery } from "@tanstack/react-query";
import DogCard from "./dogCard";

export default function Dog() {
  const path = "https://chilis-say-hi-876198057788.europe-north1.run.app/";

  const { isPending, error, data } = useQuery({
    queryKey: ["dogs"],
    queryFn: async () =>
      fetch(path + "canines", {
        method: "GET",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
      }).then((data) => data.json()),
  });

  if (isPending) {
    return "Loading..";
  }

  if (error) {
    return "Fail to fetch " + error;
  }

  console.log(data);
  return (
    <>
      <ul>
        {data.map((e) => (
          <>
            <DogCard
              name={e.name}
              breed={e.breed}
              age={e.age}
              imgUrl={e.imageUrl}
            />
          </>
        ))}
      </ul>
    </>
  );
}
