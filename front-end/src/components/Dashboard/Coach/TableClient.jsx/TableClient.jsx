import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.white,
    color: "rgba(15, 103, 8, 1)",
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

function createData(name, meeting, done, left, payement) {
  return { name, meeting, done, left, payement };
}

const rows = [
  createData('Hajar dami', "link" , 2, 6, " Done"),
  createData('Hajar dami', "link" , 2, 6, "Done"),
  createData('Hajar dami', "link" , 2, 6, "Done"),
  createData('Hajar dami', "link" , 2, 6, "Done"),
];

export default function TableClient() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 500 }} aria-label="customized table">
        <TableHead >
          <TableRow>
            <StyledTableCell>Client name</StyledTableCell>
            <StyledTableCell align="right">shudule meeting</StyledTableCell>
            <StyledTableCell align="right">session done</StyledTableCell>
            <StyledTableCell align="right">session left</StyledTableCell>
            <StyledTableCell align="right">payement</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component="th" scope="row">
                {row.name}
              </StyledTableCell>
              <StyledTableCell align="right">{row.meeting}</StyledTableCell>
              <StyledTableCell align="right">{row.done}</StyledTableCell>
              <StyledTableCell align="right">{row.left}</StyledTableCell>
              <StyledTableCell align="right">{row.payement}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
