import React from "react";
import TextButton from "../TextButton";
import { Hidden } from "@mui/material";

function AboutUs() {
  return (
    <Hidden mdDown>
      <TextButton value="Qui sommes-nous ?" url="/aboutus" />
    </Hidden>
  );
}
export default AboutUs;
