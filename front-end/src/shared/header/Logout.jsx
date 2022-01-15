import React from "react";
import MyButton from "../MyButton";

function Logout() {
  let handleClick = () => {
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isStudent");
    localStorage.removeItem("isAdmin");
    window.location.href = "/";
  };
  return (
    <MyButton
      bgColor="rgba(0,86,210,1)"
      fgColor="white"
      className="Logout"
      value="Se déconnecter"
      onClick={handleClick}
    />
  );
}
export default Logout;
