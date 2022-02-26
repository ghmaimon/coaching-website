import './css/App.css';

import Header from './shared/header/header';
import Home from "./components/Home/Home";
import Footer from "./shared/footer/Footer";
import SignUp from "./components/signup/SignUp"
import SignIn from "./components/Signin/SignIn"
import AddOffer from './components/Offer/AddOffer/AddOffer';
import Profil from "./components/Dashboard/Client/profil"
import CoachProfil from "./components/Dashboard/Coach/profil"
import AdminProfil from "./components/Dashboard/Admin/profil"
import {useEffect, useState} from "react";
import {Helmet} from "react-helmet";
import {BrowserRouter as Router, Route, Routes, useRoutes} from "react-router-dom";
import Forgot from "./components/Forgot/Forgot"
import {isAdmin, isGuest, isMentee, isMentor} from "./service/authentication";
import Details from './components/Offer/ClientConsultOffer/Details';
import ConsultOffer from "./components/Offer/CoachConsultOffer/ConsultOffer"
import MyClient from "./components/Offer/ConsultClient/MyClient"

const MenteeRoutes = () => useRoutes([
     {path: "/", element: <Profil/>},
    {path: "/profil", element: <Profil/>},
    {path:"/details", element: <Details/>}
]);
const MentorRoutes = () => useRoutes([

    {path: "/", element: <CoachProfil/>},
    {path: "/profil", element: <CoachProfil/>},
    {path:"/add_offer",element:<AddOffer/>},
    {path:"/offers",element:<ConsultOffer/>},
    {path:"/offers/clients",element:<MyClient/>}

]);
const AdminRoutes = () => useRoutes([
    {path: "/", element: <AdminProfil/>},
    {path: "/profil", element: <AdminProfil/>}
]);
const GuestRoutes = () => useRoutes([
    {path: "/", element: <Home/>},
    {path: "/profil", element: <Home/>},
    {path: "/signin", element: <SignIn/>},
    {path: "/signup", element: <SignUp/>},
    {path: "/forgotPassword", element: <Forgot/>},


]);

function App() {
    console.log(Home);
    const [logedIn, setLogedIn] = useState(false);
    const [bottom, setBottom] = useState(false);
    useEffect(() => {
        if (
            localStorage.getItem("currentUser") !== undefined &&
            localStorage.getItem("currentUser") !== null
        )
            setLogedIn(true);
        console.log(logedIn);
    });
    return (
        <>
            <Helmet>
                <title>Gestion de cours</title>
            </Helmet>

            <Router>
                <div className="body">
                    <Header/>
                    {isMentee() &&  <MenteeRoutes/>}
                    {isMentor() && <MentorRoutes/>}
                    {isAdmin() && <AdminRoutes/>}
                    {isGuest() && <GuestRoutes/>}
                    <Footer/>
                    {/*<MenteeRoute path="/"/>*/}
                    {/*<Routes>*/}
                    {/*    /!*this is for the mentee*!/*/}
                    {/*    {isMentee() && <Route element={<Profil/>} path={["/", "/profil"]}/>}*/}

                    {/*    /!*this is for the mentor*!/*/}
                    {/*    {isMentor() && <Route element={<CoachProfil/>} path="/"/>}*/}

                    {/*    /!*this is for the admin*!/*/}
                    {/*    {isAdmin() && <Route element={<AdminProfil/>} path="/"/>}*/}

                    {/*    /!*guest*!/*/}
                    {/*    {isGuest() &&*/}
                    {/*    <>*/}
                    {/*        <Route element={<Home/>} path="/"/>*/}
                    {/*        <Route element={<SignIn/>} path="/signin"/>*/}
                    {/*        <Route element={<SignUp/>} path="/signup"/>*/}
                    {/*        <Route element={<Forgot/>} path="/forgotPassword"/>*/}

                    {/*    </>*/}
                    {/*    }*/}
                    {/*</Routes>*/}

                </div>
            </Router>

        </>
    );
}

export default App;
/*I didn't start router...*/