import React from "react";
import TextButton from "../TextButton";
import { Hidden } from "@mui/material";

function ContactUs() {
  return (
    <Hidden mdDown>
      <TextButton value="Contactez-nous" url="/contactus" />
    </Hidden>
  );
}
export default ContactUs;
