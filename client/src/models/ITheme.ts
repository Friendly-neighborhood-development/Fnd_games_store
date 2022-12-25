import React from "react";
import {IIcon} from "../types/IIcon";

export interface ITheme {
    id: number,
    mode: "light" | "dark" | "system"
    Icon: React.FC<IIcon>
}