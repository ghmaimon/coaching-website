import * as React from 'react';
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
import email from '../../css/email.png'
import Image from '../Home/Image'


function Copyright(props) {
    return ( <
        Typography variant = "body2"
        color = "text.secondary"
        align = "center" {...props } > { 'Copyright © ' } <
        Link color = "inherit"
        href = "" >
        MEET FITNESS<
        /Link>{' '} { new Date().getFullYear() } { '.' } < /
        Typography >
    );
}

const theme = createTheme();

export default function SignIn() {

    return ( 
        <ThemeProvider theme = { theme } >
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
        </Box >
        </Container>
        <Grid container xs={12} md={12}>
        <Grid item md={5} xs={5} ></Grid>
        <Grid item md={4} xs={4} > 
            <Image image={email}/>
        </Grid>
        <Grid item md={4} xs={4} ></Grid>
        </Grid>
        </ThemeProvider>
    );
}