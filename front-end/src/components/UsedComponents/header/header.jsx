import * as React from 'react';

import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';

import Contactus from "./Contactus"

import '../../../css/App.css';
import logo from "../../../css/logo.png"
import AppName from "./AppName.jsx"
import Searching from "./Searching.jsx"
import Profile from "./Profile.jsx"

export default function Header() {



return ( <div className='header'>
    <Box sx={{ flexGrow: 1 }}>
   <AppBar  style={{ background: 'white' }} >
        <Toolbar>
        <Box sx={{ flexGrow: 2 }} />
        <AppName/>
        <Box sx={{ flexGrow: 4 }} />
          <Toolbar>
          <Box
            component="img"
            sx={{
            height: 40,
            }}
            alt="Your logo."
            src={logo}
        />
      </Toolbar>
      <Box sx={{ flexGrow: 4 }} />
      <Searching/>

    <Box sx={{ flexGrow: 10 }} />
    
<Profile/>
         
<Box sx={{ flexGrow: 1 }} />
    <Contactus/>     
        
        </Toolbar>
      </AppBar>
 
   
    </Box>
    </div>
  );
}
