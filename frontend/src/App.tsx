import "./App.css";
import Dog from "./components/dog";
import Dogspawner from "./components/dogSpawner";

function App() {
  return (
    <>
      <h1>Chilis Greeting Service @TM</h1>
      <Dogspawner />
      <Dog />
    </>
  );
}

export default App;
