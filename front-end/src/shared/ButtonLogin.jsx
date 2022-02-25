
import React from "react";
import Button from "@mui/material/Button";
import { makeStyles } from "@mui/styles";
import "../css/App.css"

let useStyle = makeStyles({
  root: {
    backgroundColor: "#3FA437",
    color: "black",
    borderRadius: 100,
    borderColor: "#316300",
    border: "2px double #cccccc",
    fontFamily: "Rubik Beastly",
    fontSize: "15px",

  },
});
function ButtonLogin(props) {
  let style = useStyle();
  return (
    <Button disableRipple className={style.root} size="small" href={props.href} onClick={props.onClick}>
      {props.name} 
    </Button>
  );
}
export default ButtonLogin;
