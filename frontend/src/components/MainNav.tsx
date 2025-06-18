'use client';

import { Button, Stack } from '@mui/material';
import Link from 'next/link';

export default function MainNav() {
  return (
      <Stack direction="row" spacing={2}>
        <Button color="inherit" component={Link} href="/">
          Home
        </Button>
      </Stack>
  );
}
