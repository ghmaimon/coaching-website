import './css/App.css';

import Header from './shared/header/header';
import Home from "./components/Home/Home";
import Footer from "./shared/footer/Footer";
import Profil from "./components/Dashboard/Admin/profil";
import SignUp from "./components/signup/SignUp"
import SignIn from "./components/Signin/SignIn"
import AddOffer from './components/Offer/AddOffer/AddOffer';

function App() {
    console.log(Home);
    return (

        <div className = "body" >
        <Header /> { /*<Home/>*/ } { /* <Profil /> */ } 
        <AddOffer/>
        <Footer />
        </div>
    );
}

export default App;
/*I didn't start router...*/