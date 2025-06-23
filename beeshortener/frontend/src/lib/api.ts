'use client';

import axios from 'axios';

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
    "Access-Control-Allow-Origin": "*"
  },
});

api.interceptors.request.use((config) => {
  console.log('Base URL da requisição:', config.baseURL);
  return config;
});

export default api;
