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
import {createTheme, ThemeProvider} from '@mui/material/styles';
import axios from "axios";
import {useState} from "react";
import {goto} from "../../service/utils";

function getRole(key) {
    return key.substring(1, key.length - 1);
}

function getJWT(value) {
    return value.authorization;
}

function extractRoleAndJWT(data) {
    let tempRole = undefined;
    let tempAuth = undefined;
    Object.entries(data).forEach(([key, value]) => {
        tempRole = getRole(key);
        tempAuth = getJWT(value);
        return;
    });
    return [tempRole, tempAuth];
}

function Copyright(props) {
    return (<
            Typography variant="body2"
                       color="text.secondary"
                       align="center" {...props} > {'Copyright © '} <
            Link color="inherit"
                 href="">
            MEET FITNESS<
        /Link>{' '} {new Date().getFullYear()} {'.'} < /
            Typography>
    );
}

const theme = createTheme();

export default function SignIn() {
    const [successful, setSuccessful] = useState(false);
    const handleSubmit = (event) => {
        event.preventDefault();
        // alert(event.currentTarget)
        console.log(event.currentTarget)
        const data = new FormData(event.currentTarget);
        // eslint-disable-next-line no-console
        console.log({
            email: data.get('email'),
            password: data.get('password'),
        });
        const dataToSend = {
            email: data.get('email'),
            password: data.get('password')

        }

        axios.post(`http://localhost:8000/login`, dataToSend, {
            headers: {
                'Content-Type': 'application/json',
            }
        }).then(
            (res) => {
                let resData = extractRoleAndJWT(res.data);
                localStorage.setItem("currentUser", resData[1]);
                if (resData[0] === "ROLE_COACH") {
                    localStorage.setItem("isMentee", "false");
                } else if (resData[0] === "ROLE_CLIENT") {
                    localStorage.setItem("isMentee", "true");
                } else if (resData[0] === "ROLE_SUPERUSER") {
                    localStorage.setItem("isAdmin", "true");
                }
                setSuccessful(true);
                console.log(resData);
                goto("/");
            }
            ,
            (err) => {
                alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
                console.error(err);
            }
        );

    };

    return (<
        ThemeProvider theme={theme}>
        <
            Container component="main"
                      maxWidth="xs">
            <
                CssBaseline / >
                <
                    Box sx={
                    {
                        marginTop: 12,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }
                }>
                    <
                        Avatar sx={
                        {m: 1, bgcolor: '#2e7d32'}
                    }>
                        < LockOutlinedIcon/>
                    <
        /Avatar> <
                    Typography component="h1"
                               variant="h5"
                               color="#2e7d32">
                    Sign in
                <
        /Typography> <
                    Box component="form"
                        onSubmit={handleSubmit}
                        noValidate sx={
                    {mt: 1}
                }>
                    <
                        TextField margin="normal"
                                  required fullWidth id="email"
                                  label="Email Address"
                                  name="email"
                                  autoComplete="email"
                                  color="success"
                                  autoFocus /
                    >
                        <
                            TextField margin="normal"
                                      required fullWidth name="password"
                                      label="Password"
                                      type="password"
                                      color="success"
                                      id="password"
                                      autoComplete="current-password" /
                        >
                            <
                                FormControlLabel control={< Checkbox value="remember"
                                                                     color="success" / >
                                }
                                label = "Remember me" /
                                >
                                <
                                    Button type="submit"
                                           fullWidth variant="contained"
                                           color="success"
                                           sx={
                                               {mt: 3, mb: 2}
                                           }>
                                    Sign In <
        /Button> <
                                Grid container>
                                <
                                    Grid item xs>
                                    <
                                        Link href="/forgotPassword"
                                             color="#2e7d32"
                                             variant="body2">
                                        Mot de passe oublié ?
                                    <
        /Link>
                                </Grid>
                                <Grid item>
                                    <
                                        Link href="#"
                                             color="#2e7d32"
                                             variant="body2"> {"Don't have an account? Sign Up"}
                                    </Link>
                                < /Grid>
                            </Grid>
                            </Box>
                                </Box> <
                                Copyright sx = {
                            {mt: 8, mb: 4}
                            }
                                /> < /
                                Container >
                            {successful && (
                                <Box mt={5}>
                                <div
                                style={{
                                padding: "10px",
                                marginBottom: "-20px",
                                borderRadius: "3px 3px 3px 3px",
                                color: "#270",
                                backgroundColor: "#DFF2BF",
                            }}
                                >
                                Vous êtes connectés
                                </div>
                                </Box>
                                )}
                                <
                /ThemeProvider>

                                );
                            }