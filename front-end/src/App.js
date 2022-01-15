import './css/App.css';
// import Header from "./shared/header/Header";
import MyButton from "./shared/MyButton";
import TextButton from "./shared/TextButton";
import Copyright from "./shared/Copyright";
function App() {
  return (
    <div className="App">
      <MyButton value="hello" />
      <TextButton value="hello" />
      <Copyright />
      <h1>hello</h1>
    </div>
  );
}

export default App;
