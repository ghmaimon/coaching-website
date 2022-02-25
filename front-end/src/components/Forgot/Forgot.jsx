import React, {useState} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import { goto } from '../../service/utils';

function Copyright(props) {
    return ( <Typography variant = "body2"
        color = "text.secondary"
        align = "center" {...props } > { 'Copyright © ' } <Link color = "inherit"
        href = "" >
        MEET FITNESS</Link>{' '} { new Date().getFullYear() } { '.' } </Typography >
    );
}

const theme = createTheme();

export default function SignIn() {
    const [email, setEmail] = useState('email');

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post('http://127.0.0.1:8000/api/account/forgotPassword',{}, {headers: {'email': email}}).then(() => {
            goto("/EmailSent")
        });
    };

    const storeEmail = (event) => {
        setEmail(event.target.value)
    }

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
            }
        } >
        <Avatar sx = {
            { m: 1, bgcolor: '#2e7d32' }
        } >
        <LockOutlinedIcon />
        </Avatar> <Typography component = "h1"
        variant = "h5"
        color = "#2e7d32" >
        Forgot password
        </Typography> 
        <Box component = "form"
        noValidate sx = {
            { mt: 1 }
        } >
        <TextField margin = "normal"
        onChange={storeEmail}
        value={email}
        required fullWidth id = "email"
        label = "Email Address"
        name = "email"
        autoComplete = "email"
        color = "success"
        autoFocus />
       
        
        <Button type = "submit"
        href = "/EmailSent"
        fullWidth variant = "contained"
        onClick= { handleSubmit }
        color = "success"
        sx = {
            { mt: 3, mb: 2 }
        } >
        Envoyer </Button> 
        <Grid container >
        <Grid item >
        <Link href = "#"
        color = "#2e7d32"
        variant = "body2" > { "Don't have an account? Sign Up" } </Link> 
        </Grid > </Grid> 
        </Box > </Box> <Copyright sx = {
            { mt: 8, mb: 4 }
        }
        /> </Container > </ThemeProvider>
    );
}