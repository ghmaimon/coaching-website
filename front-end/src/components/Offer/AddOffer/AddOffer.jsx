import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import AdapterDateFns from '@mui/lab/AdapterDateFns';
import LocalizationProvider from '@mui/lab/LocalizationProvider';
import DatePicker from '@mui/lab/DatePicker';

import Title from "../Title"
function Copyright(props) {
    return ( <Typography variant = "body2" color = "text.secondary"
        align = "center" {...props } > { 'Copyright © ' } 
        < Link color = "inherit"
        href = "https://mui.com/" >
        Your Website </Link>{' '} { new Date().getFullYear() } { '.' } </Typography >
    );
}

const theme = createTheme();

export default function AddOffer() {

    const [date, setDate] = React.useState(Date.now());

    const handleChange = (newValue) => {
        setDate(newValue);
    };
    const handleSubmit = (event) => {
       //traitement
        
    };

    return ( <ThemeProvider theme = { theme } >
        <Container component = "main"
        maxWidth = "xs" >
        
        <CssBaseline />

   
        <Box sx = {
            {
                marginTop: 12,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                width:"500px"

            }
        } >
        
        <Title/> < Box component = "form"
        noValidate onSubmit = { handleSubmit }
        sx = {
            { mt: 3 }
        } >
        < Grid container spacing = { 2 } >
        <Grid item xs = { 12 }
        sm = { 6 } >
        </Grid> <Grid item xs = { 12 } >
        <TextField required fullWidth 
        label = "Enter the offre name"
        name = "Enter the offre name"
        id="id"
        name="name"
        
        color = "success" />
        </Grid> <Grid item xs = { 12 } >
        <TextField required fullWidth name = "Enter the offer description"
        label = "Enter the offer description"
        id="description"
        name="description"
        color = "success" />
        </Grid>
        <Grid item xs = { 12 } >
        <TextField required fullWidth 
        name = "Min price"
        label = "minumum price you suggest"
      
      
        color = "success" />
        </Grid>
        <Grid item xs = { 12 } >
        <TextField required fullWidth 
        name = "max price "
        label = "maximum price you suggest"
       
        color = "success" />
        </Grid>
        <Grid item xs = {2} ></Grid>
        <Grid item xs = {8} >
        <LocalizationProvider dateAdapter={AdapterDateFns}>
      <DatePicker
        label="Creation date"
        value={date}
        onChange={(newValue) => {
          setDate(newValue);
        }}
        renderInput={(params) => <TextField {...params} />}
      />
    </LocalizationProvider>
  
        </Grid>
         </Grid > 
        <Button type = "submit"
fullWidth variant = "contained"
        color = "success"
        sx = {
            { mt: 3, mb: 2 }
        } >

        Add the offer </Button> <Grid container justifyContent = "flex-end" >
       
        </Grid> 
        </Box >
         </Box> 
         <Copyright sx = {
            { mt: 5 }
        }
        /> </Container > 
        </ThemeProvider>
    );
}