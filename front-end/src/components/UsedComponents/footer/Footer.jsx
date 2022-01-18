import React from "react";

import Copyright from "../Copyright";


import Grid from "@mui/material/Grid";


function Footer(props) {
  
  return (
    
<Grid container>
<Grid  item md={5} xs={5}></Grid>
<Grid item md={3} xs={3}><Copyright title="MEET FITNESS" /></Grid>
<Grid  item md={4} xs={4}></Grid>
</Grid>
        
          
          
 
  );
}
export default Footer;