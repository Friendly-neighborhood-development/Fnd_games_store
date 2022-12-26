import React from "react";
import {IIcon} from "../types/IIcon";

export interface ITheme {
    id: number,
    title: "light" | "dark" | "system"
    Icon: React.FC<IIcon>
}