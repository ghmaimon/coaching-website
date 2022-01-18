
import React from "react";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import "../../css/App.css"

let useStyle = makeStyles({
  root: {
    backgroundColor: "#3FA437",
    color: "black",
    borderRadius:100,
    borderColor:"#316300",
    border: "2px double #cccccc",
    fontFamily: "Rubik Beastly",
    fontSize: "15px",
 
  },
});
function ButtonLogin(props) {
  let style = useStyle();
  return (
    <Button disableRipple className={style.root} size="small" href={props.href}>
      {props.name}
    </Button>
  );
}
export default ButtonLogin;
