import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import "./App.css";
import Dog from "./components/dog";
import Dogspawner from "./components/dogSpawner";

const queriClient = new QueryClient();

function App() {
  return (
    <>
      <QueryClientProvider client={queriClient}>
        <h1>Chilis Greeting Service @TM</h1>
        <Dogspawner />
        <Dog />
      </QueryClientProvider>
    </>
  );
}

export default App;
