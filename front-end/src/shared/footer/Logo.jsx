import React from "react";
import Button from "@mui/material/Button";
import { makeStyles } from "@mui/styles";
let useStyle = makeStyles({
  root: {
    backgroundColor: "transparent",
    color: "rgba(0, 86, 210, 1)",
    float: "left",
    radius: 0,
    marginRight: "20px",
    fontFamily: "montserrat",
    fontWeight: "bold",
    "&:hover": {
      backgroundColor: "transparent",
    },
  },
});
function Logo() {
  let style = useStyle();
  return (
    <Button disableRipple className={style.root} size="small" href="/">
      Coaching Center
    </Button>
  );
}
export default Logo;
