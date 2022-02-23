
import React from "react";
import VideoBg from "./vide2.mp4";
import  "../../../css/App.css"
import { height } from "@mui/system";
function Video (props)  {
    return(
  <video    style={{
    width:"100% ",
    height:"20%",
    textAlign: "center",      
                     

}} autoPlay muted loop>
    <source src={VideoBg} type="video/mp4" />
  </video>)
}



export default Video;
