'use client';

import {AppBar, Toolbar, Typography} from '@mui/material';
import MainNav from './MainNav';

export default function Header() {
  return (
      <AppBar position="static" color="primary" enableColorOnDark sx={{ borderRadius: 0}}>
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            Bee Shortener
          </Typography>
          <MainNav />
        </Toolbar>
      </AppBar>
  );
}
