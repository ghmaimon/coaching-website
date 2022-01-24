
import React from "react";
import Button from "@mui/material/Button";
import { makeStyles } from "@mui/styles";

let useStyle = makeStyles({
  root: {
    backgroundColor: "transparent",
    color: "rgba(15, 103, 8, 1)",
    float: "left",
    radius: 0,

    fontFamily: "montserrat",
    fontSize: "15px",
    fontWeight: "bold",
    "&:hover": {
      backgroundColor: "transparent",
    },
  },
});
function AppName() {
  let style = useStyle();
  return (
    <Button disableRipple className={style.root} size="small" href="/">
      Meet fitness
    </Button>
  );
}
export default AppName;
