import React from "react";
import MyButton from "../MyButton";

function SignIn() {
  return (
    <MyButton
      bgColor="white"
      fgColor="rgba(0,86,210,1)"
      className="signIn"
      value="Se connecter"
      url="/signin"
    />
  );
}
export default SignIn;
