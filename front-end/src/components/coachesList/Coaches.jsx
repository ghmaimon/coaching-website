import * as React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import {useEffect, useState} from "react";
import {getAllOffers} from "../../service/offer";
import {getAllCoaches, verifyCoach} from "../../service/personalData";
import MyButton from "../../shared/MyButton";

const columns = [
    {id: 'name', label: 'Coach', minWidth: 170},
    {id: 'image', label: 'Image', minWidth: 100},
    {
        id: 'cin',
        label: "Document d'identité",

    },
    {
        id: 'certificate',
        label: 'Certificat de coaching',

    },
    {
        id: 'Statut',
        label: 'statut',

    },
];


export function createData(name, image, cin, certificate, Statut, id) {
    return {name, image, cin, certificate, Statut, id};
}

export default function StickyHeadTable() {

    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);
    let [courses, setCourses] = useState({data: ""});
    const [rows, setRows] = useState([]);
    const [success, setSuccess] = useState(false);
    const [count, setCount] = useState(0);
    if (rows.length === 0 && success === false   )
        getAllCoaches(setRows, createData, setSuccess)
    useEffect(() => {
        return () => {

            if (count > 10) return;
            setCount(count + 1);
            if (rows.length === 0)
                getAllCoaches(setRows, createData, setSuccess)
        };
    }, []);


    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <>{(success === false ) ? <h1>Loading</h1> :
            <Paper sx={{width: '100%', overflow: 'hidden'}}>
                <TableContainer sx={{maxHeight: 440, marginTop: "100px"}}>
                    <Table stickyHeader aria-label="sticky table">
                        <TableHead>
                            <TableRow>
                                {columns.map((column) => (
                                    <TableCell
                                        key={column.id}
                                        align={column.align}
                                        style={{minWidth: column.minWidth}}
                                    >
                                        {column.label}
                                    </TableCell>
                                ))}
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows
                                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                                .map((row) => {
                                    return (
                                        <TableRow hover role="checkbox" tabIndex={-1} key={row.image}>
                                            {columns.map((column) => {


                                                const value = row[column.id];
                                                if (column.id === "Statut"){
                                                    return (

                                                        <TableCell key={column.id} align={column.align}>
                                                            <MyButton value={"vérifier"} onClick={()=>{verifyCoach(value)}}/>
                                                        </TableCell>
                                                    );
                                                }
                                                return (
                                                    <TableCell key={column.id} align={column.align}>
                                                        {column.format && typeof value === 'number'
                                                            ? column.format(value)
                                                            : value}
                                                    </TableCell>
                                                );
                                            })}
                                        </TableRow>
                                    );
                                })}
                        </TableBody>
                    </Table>
                </TableContainer>
                <TablePagination
                    rowsPerPageOptions={[10, 25, 100]}
                    component="div"
                    count={rows.length}
                    rowsPerPage={rowsPerPage}
                    page={page}
                    onPageChange={handleChangePage}
                    onRowsPerPageChange={handleChangeRowsPerPage}
                />
            </Paper>}</>
    );
}
