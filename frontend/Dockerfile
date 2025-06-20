# Etapa 1: build da aplicação
FROM node:20-alpine AS builder

# Reduz número de dependências globais e aumenta performance do npm
ENV NODE_ENV=production \
    NEXT_TELEMETRY_DISABLED=1

WORKDIR /app

# Instala apenas as dependências necessárias para build
COPY package.json package-lock.json* ./
RUN npm ci --omit=dev

# Copia o restante do código
COPY . .

# Define ARG para build-time
ARG NEXT_PUBLIC_BASE_URL
ENV NEXT_PUBLIC_BASE_URL=$NEXT_PUBLIC_BASE_URL

# Build do Next.js
RUN npm run build

# Remove arquivos desnecessários (testes, docs, etc.)
RUN rm -rf tests __tests__ docs

# Etapa 2: imagem final super enxuta
FROM node:20-alpine AS runner

WORKDIR /app

ENV NODE_ENV=production \
    NEXT_TELEMETRY_DISABLED=1 \
    PORT=3000

# Apenas as dependências de produção
COPY --from=builder /app/package.json ./
COPY --from=builder /app/node_modules ./node_modules

# Apenas os arquivos essenciais
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/public ./public
COPY --from=builder /app/next.config.ts ./
COPY --from=builder /app/package.json ./
COPY --from=builder /app/tsconfig.json ./

EXPOSE 3000

# Usa um processo mais leve, sem shell
CMD ["node", "node_modules/next/dist/bin/next", "start"]
