import api from "@/lib/api";
import {EncodeOutput} from "@/interfaces/EncodeOutput";
import {EncodeInput} from "@/interfaces/EncodeInput";

export async function saveURL(longURL: string) {
  const data: EncodeInput = {
    longURL: longURL
  }

  return await api.post<EncodeOutput>("/", data)
}