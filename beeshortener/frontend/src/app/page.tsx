"use client";

import {Box, Button, Grid, IconButton, Snackbar, TextField, Typography} from "@mui/material";
import ContentCopyIcon from '@mui/icons-material/ContentCopy';
import {EncodeOutput} from "@/interfaces/EncodeOutput";
import {useState} from "react";
import {saveURL} from "@/service/saveURL";

export default function Home() {
  const [longURL, setLongURL] = useState<string>("")
  const [isLoading, setIsLoading] = useState<boolean>(false)
  const [savedURL, setSavedURL] = useState<EncodeOutput>()
  const [open, setOpen] = useState(false);

  async function handleShorten() {
    console.log(longURL)
    if (longURL.length > 0) {
      try {
        setIsLoading(true)
        const result = await saveURL(longURL)
        setSavedURL(result.data)
      } catch (e) {
        console.log(e)
      } finally {
        setIsLoading(false)
      }
    }
  }

  async function handleCopy() {
    if (savedURL) {
      await navigator.clipboard.writeText(`${process.env.NEXT_PUBLIC_BASE_URL}/${savedURL.code}`)
      setOpen(true)
    }
  }

  return (
      <Box
          display="flex"
          justifyContent="center"
          alignItems="center"
          height="80vh"
      >
        <Grid container width="100%" spacing={2}>
          <Grid size={{
            xs: 12,
            md: 9
          }}>
            <TextField
                fullWidth
                name="longURL"
                value={longURL}
                onChange={(e) => setLongURL(e.target.value)}
                placeholder={"https://www.example.com"}
                size="medium"
            />
          </Grid>

          <Grid
              display="flex"
              justifyContent="center"
              size={{
                xs: 12,
                md: 3
              }}>
            <Button
                fullWidth
                variant="outlined"
                loading={isLoading}
                onClick={handleShorten}
            >Make it shorter</Button>
          </Grid>
          {savedURL && (
              <Grid size={{xs: 12}}
                    display="flex"
                    flexDirection="row"
                    gap={1}
                    justifyContent="center"
                    alignItems="center"
              >
                <Typography variant="h5" color="primary">
                  {`Your shortened URL is: ${process.env.NEXT_PUBLIC_BASE_URL}/${savedURL.code}`}
                </Typography>
                <IconButton onClick={handleCopy}>
                  <ContentCopyIcon color={"primary"}/>
                </IconButton>
              </Grid>
          )}
        </Grid>
        <Snackbar
            open={open}
            autoHideDuration={2000}
            onClose={() => setOpen(false)}
            message="Copied to clipboard"
        />
      </Box>
  )
}
