import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CourseFormComponent } from './container/course-form/course-form.component';
import { CoursesComponent } from './container/courses/courses.component';
import { CourseResolver } from './guards/course.resolver';

const routes: Routes = [
  { path: '', component: CoursesComponent },
  { path: 'new', component: CourseFormComponent, resolve: {curso: CourseResolver } },
  { path: 'edit/:id', component: CourseFormComponent, resolve: {curso: CourseResolver} }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
 