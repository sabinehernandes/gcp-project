import "./App.css";
import Dogspawner from "./components/dogSpawner";
import Greeter from "./components/greeter";

function App() {
  return (
    <>
      <h1>Chilis Greeting Service @TM</h1>
      <Greeter />
      <Dogspawner />
    </>
  );
}

export default App;
