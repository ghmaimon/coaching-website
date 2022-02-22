
import React from "react";

import feuille from "../../../css/feuille.png"
import iversefeuille from "../../../css/feuilleinv.png"
import { makeStyles } from "@mui/styles";
import desc from "../../Home/Desc"
import "../../../css/App.css"
import { Grid } from "@mui/material";
import SortIcon from '@mui/icons-material/Sort';
import IconButton from '@mui/material/IconButton';
function Sort(props) {
 
  return (
    <div>
 <IconButton    type="submit" sx={{ p: "10px" }} aria-label="search"    style={{color:"white" }}>
<SortIcon  onClick={() => { /*here to insert serching traitement it depends on the backend */}} />
</IconButton>
      
    </div>

  );
}
export default Sort;

