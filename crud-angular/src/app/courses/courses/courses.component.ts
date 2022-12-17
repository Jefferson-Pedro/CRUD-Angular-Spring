import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})

export class CoursesComponent implements OnInit{
  

  cursos: Course [] = [{_id: '1', name:'Angular', category:'front-end'}];
  displayedColumns = ['name', 'category'];

  constructor(){
   
  }

  ngOnInit(): void {}
}