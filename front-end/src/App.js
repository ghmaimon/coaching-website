import './css/App.css';

import Header from './shared/header/header';
import Home from "./components/Home/Home";
import Footer from "./shared/footer/Footer";
import Profil from "./components/Dashboard/Client/profil";
import SignUp from "./components/signup/SignUp"
import SignIn from "./components/Signin/SignIn"

function App() {
    console.log(Home);
    return (

        <
        div className = "body" >
        <
        Header / > { /*<Home/>*/ } { /* <Profil /> */ } <
        SignUp / >
        <
        Footer / >
        <
        /div>
    );
}

export default App;
/*I didn't start router...*/