import type {Metadata} from 'next';
import {CssBaseline} from '@mui/material';
import BaseLayout from '@/components/BaseLayout';
import {MuiProvider} from "@/themes/MuiProvider";

export const metadata: Metadata = {
  title: 'Bee Shortener',
  description: 'Just shorten it',
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
