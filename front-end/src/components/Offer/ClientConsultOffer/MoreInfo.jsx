import React from "react";
import Grid from '@mui/material/Grid';

import "../../../css/App.css"
function MoreInfo(props) {
  return ( <div>




<p style={{ fontFamily: "Comfortaa",
                    lineHeight: "2",
        fontSize: "20px",
        fontWeight: "100",
   color:"black",
   fontStyle: "oblique",
   marginLeft:"20%",

}}> min price :  {props.maxPrice}</p>








<p style={{ fontFamily: "Comfortaa",
                    lineHeight: "2",
        fontSize: "20px",
        fontWeight: "100",
   color:"black",
   fontStyle: "oblique",
   marginLeft:"20%",
   }}> max price : {props.minPrice}</p> 

   




 
       

   <p style={{ fontFamily: "Comfortaa",
                    lineHeight: "2",
        fontSize: "20px",
        fontWeight: "100",
   color:"black",
   fontStyle: "oblique",
   marginLeft:"20%",
   
   
   }}> created : {props.date} </p>




  </div>
  );
}
export default MoreInfo;
