import React from "react";
import TextButton from "../TextButton";
import { Hidden } from "@mui/material";

function Dashboard() {
  // let isStudent = localStorage.getItem("isStudent");
  // isStudent === "true" ? (isStudent = true) : (isStudent = false);
  return (
    <Hidden mdDown>
      {/* <TextButton
        value="Mon Profil"
        url={
          localStorage.getItem("isStudent") === "true"
            ? "/dashboard"
            : localStorage.getItem("isAdmin") === "true"
              ? "/admin/dashboard"
              : "/prof/dashboard"
        }
      /> */}
    </Hidden>
  );
}
export default Dashboard;
