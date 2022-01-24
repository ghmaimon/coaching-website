
import React from "react";
import InputBase from '@mui/material/InputBase';
import Paper from "@mui/material/Paper";
import SearchIcon from '@mui/icons-material/Search';
import IconButton from '@mui/material/IconButton';

  export default function Searching() {
    let [search, setSearch] = React.useState('');
    return (
      <Paper
        component="form"
        sx={{ p: "2px 4px", display: "flex", alignItems: "center", width: 400 }}
      >
        <InputBase
          sx={{ ml: 1, flex: 1 }}
          type='text'
          placeholder="Search..."
          inputProps={{ "aria-label": "search" }}
          onChange={
              event=>{
            setSearch(event.target.value)
            }
          }
   
        />
        <IconButton    type="submit" sx={{ p: "10px" }} aria-label="search">
          <SearchIcon  onClick={() => { /*here to insert serching traitement it depends on the backend */}} />
        </IconButton>
      </Paper>
    );


}

