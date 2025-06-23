'use client';

import {Box, Typography} from '@mui/material';

export default function Footer() {
  return (
      <Box
          component="footer"
          sx={{
            mt: 4,
            py: 3,
            px: 2,
            textAlign: 'center',
            backgroundColor: 'background.paper',
          }}
      >
        <Typography variant="body2" color="text.secondary">
          © {new Date().getFullYear()}
        </Typography>
      </Box>
  );
}
