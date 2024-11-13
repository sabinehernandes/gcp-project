export default function Dog() {
  const path = "https://chilis-say-hi-876198057788.europe-north1.run.app/";

  const getDog = async () => {
    const response = await fetch(path + "canines", {
      method: "GET",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
    });
    const json = await response.json();
    console.log(json);
    return json;
  };
  const result = getDog();
  const dogs = result.map((dog) => {
    <li>{dog}</li>;
  });

  return (
    <>
      <ul>{dogs}</ul>
    </>
  );
}
