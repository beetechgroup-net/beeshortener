# Stage 1: install dependencies
FROM node:18-alpine AS deps
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build && npm prune --production

# Stage 2: run
FROM node:18-alpine
WORKDIR /app
COPY --from=deps /app/.next ./.next
COPY --from=deps /app/public ./public
COPY --from=deps /app/node_modules ./node_modules
COPY --from=deps /app/package.json ./

# Set NODE_ENV to production
ENV NODE_ENV production

EXPOSE 3000

CMD ["npm", "run", "start"]