import React, { useState, useEffect } from "react";
import SignUp from "./SignUp";
import SignIn from "./SignIn";
import ContactUs from "./ContactUs";
import AboutUs from "./AboutUs";
import Logout from "./Logout";

import Logo from "./Logo";
// import Dashboard from "./Dashboard";

function Header() {
  // const [logedIn, setLogedIn] = useState(false);
  // useEffect(() => {
  //   if (
  //     localStorage.getItem("currentUser") !== undefined &&
  //     localStorage.getItem("currentUser") !== null
  //   )
  //     setLogedIn(true);
  //   console.log("header" + logedIn);
  // });
  let logedIn = true;
  return (
    <div>
      <SignUp />
      <SignIn />
      <ContactUs />
      <AboutUs />
      <Logo />

    </div>
  );
}
export default Header;
// so far i realized that logo is the one causing not showing 