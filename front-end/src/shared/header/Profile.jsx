import * as React from 'react';

import IconButton from '@mui/material/IconButton';

import AccountCircle from '@mui/icons-material/AccountCircle';
import MenuItem from '@mui/material/MenuItem';
import Menu from '@mui/material/Menu';
import LoginIcon from '@mui/icons-material/Login';
import AssignmentIndIcon from '@mui/icons-material/AssignmentInd';
import {isGuest, logOut} from "../../service/authentication";

function Profile() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const isMenuOpen = Boolean(anchorEl);

  const handleProfileMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

 

  const handleMenuClose = () => {
    setAnchorEl(null);
   
  };



  const menuId = 'primary-search-account-menu';
  const renderMenu = (
    <Menu
      anchorEl={anchorEl}
      id="fade-menu"
    
      open={isMenuOpen}
      onClose={handleMenuClose}
     
      MenuListProps={{
        'aria-labelledby': 'fade-button',
      }}
      PaperProps={{
        style: {
        Height: "20%",
        width: "10%",
        },
    }}
    >
        {isGuest() &&
      <MenuItem onClick={handleMenuClose} >
      <IconButton
    href="/Signin"
            >
      <AssignmentIndIcon color="success" 
    /></IconButton>
        Sign In </MenuItem>}
        {!isGuest() &&
        <MenuItem onClick={handleMenuClose} >
            <IconButton
                onClick={logOut}
            >
                <AssignmentIndIcon color="success"
                /></IconButton>
            Sign Out </MenuItem>}
    {/*  <MenuItem onClick={handleMenuClose} >*/}
    {/*  <IconButton*/}
    {/*href="/login" */}
    {/*        >*/}
    {/*  <LoginIcon color="success"  */}
    {/* />*/}
    {/*       </IconButton>*/}
    {/*          Sign Out</MenuItem>*/}

    </Menu>
  );
  return (
    <div>
    <MenuItem onClick={handleProfileMenuOpen}>
    <IconButton
              
              aria-controls={menuId}
             
              onClick={handleProfileMenuOpen}
           

            >
              <AccountCircle color="success" />
            </IconButton>
            </MenuItem>
                {renderMenu}
                </div>
  );

}
export default Profile;
