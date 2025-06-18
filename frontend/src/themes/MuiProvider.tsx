'use client';

import {
  createTheme,
  ThemeProvider,
  responsiveFontSizes,
} from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import { ReactNode } from 'react';

// Optional: Install this font via npm or use Google Fonts
import '@fontsource/rubik/300.css';
import '@fontsource/rubik/400.css';
import '@fontsource/rubik/500.css';
import '@fontsource/rubik/700.css';

let theme = createTheme({
  palette: {
    mode: 'light',
    primary: {
      main: '#e60012', // Nintendo Red
      contrastText: '#fff',
    },
    secondary: {
      main: '#ffffff', // White
    },
    background: {
      default: '#ffffff',
      paper: '#ffffff',
    },
    text: {
      primary: '#1a1a1a',
      secondary: '#555',
    },
  },
  typography: {
    fontFamily: '"Rubik", sans-serif',
    h1: {
      fontWeight: 700,
      fontSize: '2.5rem',
    },
    h2: {
      fontWeight: 600,
      fontSize: '2rem',
    },
    button: {
      textTransform: 'none',
      fontWeight: 500,
    },
  },
  shape: {
    borderRadius: 12,
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          borderRadius: 12,
          transition: 'all 0.2s ease-in-out',
          ':hover': {
            transform: 'scale(1.03)',
            boxShadow: '0 4px 10px rgba(0,0,0,0.15)',
          },
        },
      },
    },
    MuiPaper: {
      styleOverrides: {
        root: {
          borderRadius: 16,
        },
      },
    },
    MuiCard: {
      styleOverrides: {
        root: {
          borderRadius: 16,
          boxShadow: '0 4px 14px rgba(0,0,0,0.1)',
        },
      },
    },
  },
});

theme = responsiveFontSizes(theme);

export function MuiProvider({ children }: { children: ReactNode }) {
  return (
      <ThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </ThemeProvider>
  );
}
