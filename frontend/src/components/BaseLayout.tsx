'use client';

import { ReactNode } from 'react';
import Header from './Header';
import Footer from './Footer';
import Container from '@mui/material/Container';
import {Box} from "@mui/material";

type Props = {
  children: ReactNode;
};

export default function BaseLayout({ children }: Props) {
  return (
      <>
        <Header />
        <Box
            display="flex"
            flexDirection="column"
            minHeight="94vh"
        >
          <Container sx={{ flex: 1, py: 4 }}>{children}</Container>
          <Footer />
        </Box>
      </>
  );
}
