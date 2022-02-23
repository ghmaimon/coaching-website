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
import PageNotFound from "./components/errors/404";
import {Helmet} from "react-helmet";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

function AdminRoute(props) {
    let temp = localStorage.getItem("isAdmin");
    if (props.inverse) {
        temp === "true" ? (temp = null) : (temp = "true");
    }
    if (temp === "true") {
        return (
            <Route
                element={props.element}

                path={props.path}
            />
        );
    }
    return (
        <Route element={<PageNotFound/>} path={props.path}/>
    );
}

function CoachRoute(props) {
    if (localStorage.getItem("isMentee") === "false") {
        return (
            <Route
                element={props.element}

                path={props.path}
            />
        );
    }
    return (
        <Route element={<PageNotFound/>} path={props.path}/>
    );
}
function isMentee(){
    return localStorage.getItem("isMentee") === "true";
}
function isMentor(){
    return localStorage.getItem("isMentee") === "false";
}
function isAdmin(){
    return localStorage.getItem("isAdmin") === "true";
}
function isGuest(){
    return localStorage.getItem("currentUser") === null || localStorage.getItem("currentUser") === undefined;
}
function MenteeRoute(props) {
    // if (localStorage.getItem("isMentee") === "true") {
    //     return (
    //         <Route
    //             element={props.element}
    //
    //             path={props.path}
    //         />
    //     );
    // }
    return <Route element={<PageNotFound/>} path="/"/>;
    return (

        <Route element={<PageNotFound/>} path={`${props.path}`}/>
    );
}

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

    function CondRoute(props) {
        //conditionnal 404
        if (props.inverse === true) {
            if (localStorage.getItem("isMentee") === "true")
                return (
                    <Route
                        element={!logedIn ? props.element : <Profil/>}

                        path={props.path}
                    />
                );
            else if (
                localStorage.getItem("isAdmin") === null ||
                localStorage.getItem("isAdmin") === undefined
            ) {
                return (
                    <Route
                        element={!logedIn ? props.element : <AddOffer/>}

                        path={props.path}
                    />
                );
            } else {
                return (
                    <Route
                        element={!logedIn ? props.element : <AdminProfil/>}

                        path={props.path}
                    />
                );
            }
        }
        return (
            <Route
                element={logedIn ? props.element : <PageNotFound/>}

                path={props.path}
            />
        );
    }

    return (
        <>
            <Helmet>
                <title>Gestion de cours</title>
            </Helmet>

            <Router>
                <div className="body">
                    <Header/>
                    {/*<MenteeRoute path="/"/>*/}

                    <Routes>
                        {/*this is for the mentee*/}
                        { !isMentee() && <Route element={<Home/>} path="/"/>}

                        {/*this is for the mentor*/}

                        {/*this is for the admin*/}

                        {/*guest*/}
                        { isGuest() && <Route element={<Home/>} path="/"/>}
                    </Routes>
                    <Footer/>
                </div>
            </Router>

        </>
    );
}

export default App;
/*I didn't start router...*/