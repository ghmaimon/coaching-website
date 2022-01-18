import React from "react";

import "../../css/App.css"
function Desc(props) {
  return (<div>
    <p
    style={{
        
   
      fontFamily: "Contrail One",
      lineHeight: "1.6",
      fontSize: "25px",
  
   marginTop:"10%", 
   }}
  >{props.txt1}
    

</p>
       <p
    style={{
        
   
      fontFamily: "Contrail One",
      lineHeight: "1.6",
      fontSize: "25px",
  

   }}
  >
       <span style={{color:"rgba(15, 103, 8, 1)"}}> {props.txt2} </span>  {props.txt3}

    
</p></div>
  );
}
export default Desc;
