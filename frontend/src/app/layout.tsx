import type {Metadata} from 'next';
import {CssBaseline} from '@mui/material';
import BaseLayout from '@/components/BaseLayout';
import {MuiProvider} from "@/themes/MuiProvider";

export const metadata: Metadata = {
  title: 'Nintendo eShop Fan',
  description: 'Next.js + MUI',
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
      <html lang="en">
      <body>
      <MuiProvider>
        <CssBaseline />
        <BaseLayout>{children}</BaseLayout>
      </MuiProvider>
      </body>
      </html>
  );
}
